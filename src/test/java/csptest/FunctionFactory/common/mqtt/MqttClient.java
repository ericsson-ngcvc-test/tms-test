/*******************************************************************************
 * Copyright (c) 2009, 2014 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution. 
 *
 * The Eclipse Public License is available at 
 *    http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *    Dave Locke - initial API and implementation and/or initial documentation
 */

package csptest.FunctionFactory.common.mqtt;

import csptest.FunctionFactory.common.*;

import org.apache.commons.lang.StringUtils;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.*;
import csptest.FunctionFactory.common.mqtt.org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.SocketFactory;
import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;

import com.jayway.restassured.response.Response;
import csptest.FunctionFactory.TEM.api.*;
import com.ericsson.csp.tsc.dispatcher.asn1.MessageTransformerImpl;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;

/**
 * A sample application that demonstrates how to use the Paho MQTT v3.1 Client
 * API in non-blocking callback/notification mode.
 *
 * It can be run from the command line in one of two modes: - as a publisher,
 * sending a single message to a topic on the server - as a subscriber,
 * listening for messages from the server
 *
 * There are three versions of the sample that implement the same features but
 * do so using using different programming styles:
 * <ol>
 * <li>Sample which uses the API which blocks until the operation completes</li>
 * <li>SampleAsyncWait shows how to use the asynchronous API with waiters that
 * block until an action completes</li>
 * <li>MqttClient (this one) shows how to use the asynchronous API where events
 * are used to notify the application when an action completes
 * <li>
 * </ol>
 *
 * If the application is run with the -h parameter then info is displayed that
 * describes all of the options / parameters.
 */
@Component
public class MqttClient implements MqttCallback {

	private static MessageTransformerImpl messageTransformer = new MessageTransformerImpl();
	Response result;

	private static final Logger logs = LoggerFactory.getLogger(MqttClient.class);
	
	private int state = BEGIN;
	private static final String           FAKE_DEVICE_ID     = "00000000000000000";

	static final int BEGIN = 0;
	static final int CONNECTED = 1;
	static final int PUBLISHED = 2;
	static final int SUBSCRIBED = 3;
	static final int DISCONNECTED = 4;
	static final int FINISH = 5;
	static final int ERROR = 6;
	static final int DISCONNECT = 7;

	// Private instance variables
	private MqttAsyncClient client;
	
	private String brokerUrl;
	private MqttConnectOptions conOpt;
	private Throwable ex = null;
	private Object waiter = new Object();
	private boolean donext = false;
	
	@Value("${mqtt.client.log.quietMode}")
	private boolean quietMode = false;
	
	//@Value("${mqtt.publish.topic}")
	//private String topic = "";
	
	@Value("${mqtt.qos}")
	private int qos = 2;
	
	@Value("${http.route.dir}")
	private String poiPath;


	public MqttClient() throws MqttException {
		System.out.println("``````````````````````````");
	}
	
	/**
	 * Constructs an instance of the sample client wrapper
	 * 
	 * @param brokerUrl
	 *            the url to connect to
	 * @param clientId
	 *            the client id to connect with
	 * @param cleanSession
	 *            clear state at end of connection or not (durable or non-durable
	 *            subscriptions)
	 * @param quietMode
	 *            whether debug should be printed to standard out
	 * @param userName
	 *            the username to connect with
	 * @param password
	 *            the password for the user
	 * @throws MqttException
	 */
	public MqttClient(String broker, int port, boolean ssl, String clientId, boolean cleanSession,
                      boolean quietMode, String userName, String password,
                      String caPath, String crtPath, String keyPath) throws MqttException {
		String protocol = "tcp://";
		if (ssl) {
			protocol = "ssl://";
		}
		this.brokerUrl = protocol + broker + ":" + port;
		System.out.println("######################################################");
		
		// This sample stores in a temporary directory... where messages temporarily
		// stored until the message has been delivered to the server.
		// ..a real application ought to store them somewhere
		// where they are not likely to get deleted or tampered with
		//String tmpDir = System.getProperty("java.io.tmpdir");
		//MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(tmpDir);

		try {
			// Construct the object that contains connection parameters
			// such as cleanSession and LWT
			conOpt = new MqttConnectOptions();
			conOpt.setCleanSession(cleanSession);
			if (password != null) {
				conOpt.setPassword(password.toCharArray());
			}
			if (userName != null) {
				conOpt.setUserName(userName);
			}

			if (ssl){
				try {
					SocketFactory socketFactory = SslUtil.getSSLSocktet(caPath, crtPath, keyPath, password);
					conOpt.setSocketFactory(socketFactory);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Construct the MqttClient instance
			//client = new MqttAsyncClient(this.brokerUrl, clientId+System.currentTimeMillis(), null);
			client = new MqttAsyncClient(this.brokerUrl, clientId, null);

			// Set this wrapper as the callback handler
			client.setCallback(this);

		} catch (MqttException e) {
			e.printStackTrace();
			log("Unable to set up client: " + e.toString());
			System.exit(1);
		}
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/**
	 * Publish / send a message to an MQTT server
	 * 
	 * @param topicName
	 *            the name of the topic to publish to
	 * @param qos
	 *            the quality of service to delivery the message at (0,1,2)
	 * @param payload
	 *            the set of bytes to send to the MQTT server
	 * @throws MqttException
	 */
	public void publish(String ServiceId, int qos, byte[] byteMessage) throws Throwable {
		/*if (StringUtils.isEmpty(topicName)) {
			topicName = topic;
		}*/

//		for (int t=5;t>0;t--){
//			System.out.print("before publish " + t + " seconds\n");
//			Thread.sleep(1000);
//		}

		logs.info("state: " + state);
		//state = BEGIN;
		String topicName = "VDE/TEM/" + ServiceId;
		logs.info("topic = " + topicName);
		logs.info("Qos = " + qos);

		byte[] encodedByte = new byte[0];
		try {
			encodedByte = messageTransformer.downlinkTransform(FAKE_DEVICE_ID, ServiceId, byteMessage);
		} catch (Throwable e) {
			logs.error("transform message error", e);
		}

		// true connected
		boolean conState = client.isConnected();
		if (!conState) {
//			Disconnector disc = new Disconnector();
//			disc.doDisconnect();
//			
//			for (int t=3;t>0;t--){
//			System.out.print("after disconnect " + t + " seconds\n");
//			Thread.sleep(1000);
//			}
//			
			// Connect using a non-blocking connect
			MqttConnector con = new MqttConnector();
			con.doConnect();
			waitForStateChange(10000);
			
//			for (int t=3;t>0;t--){
//			System.out.print("after connect " + t + " seconds\n");
//			Thread.sleep(1000);
//			}

			// Publish using a non-blocking publisher
			Publisher pub = new Publisher();
			pub.doPublish(topicName, qos, encodedByte);
			waitForStateChange(10000);
		} else {
			// Publish using a non-blocking publisher
			Publisher pub = new Publisher();
			pub.doPublish(topicName, qos, encodedByte);
			waitForStateChange(10000);
		}
		
		
		
		// Use a state machine to decide which step to do next. State change occurs
		// when a notification is received that an MQTT action has completed
		/*while (state != FINISH) {
			switch (state) {
			case BEGIN:
				// Connect using a non-blocking connect
				MqttConnector con = new MqttConnector();
				con.doConnect();
				break;
			case CONNECTED:
				// Publish using a non-blocking publisher
				Publisher pub = new Publisher();
				pub.doPublish(topicName, qos, payload);
				break;
			case PUBLISHED:
				//state = DISCONNECT;
				donext = true;
				break;
			case DISCONNECT:
				Disconnector disc = new Disconnector();
				disc.doDisconnect();
				break;
			case ERROR:
				throw ex;
			case DISCONNECTED:
				state = FINISH;
				donext = true;
				break;
			}

			// if (state != FINISH) {
			// Wait until notified about a state change and then perform next action
			waitForStateChange(10000);
			// }
		}*/
	}

	/**
	 * Wait for a maximum amount of time for a state change event to occur
	 * 
	 * @param maxTTW
	 *            maximum time to wait in milliseconds
	 * @throws MqttException
	 */
	private void waitForStateChange(int maxTTW) throws MqttException {
		synchronized (waiter) {
			if (!donext) {
				try {
					waiter.wait(maxTTW);
				} catch (InterruptedException e) {
					log("timed out");
					e.printStackTrace();
				}

				if (ex != null) {
					throw (MqttException) ex;
				}
			}
			donext = false;
		}
	}

	/**
	 * Subscribe to a topic on an MQTT server Once subscribed this method waits for
	 * the messages to arrive from the server that match the subscription. It
	 * continues listening for messages until the enter key is pressed.
	 * 
	 * @param topicName
	 *            to subscribe to (can be wild carded)
	 * @param qos
	 *            the maximum quality of service to receive messages at for this
	 *            subscription
	 * @throws MqttException
	 */
	public void subscribe(String topicName, int qos) throws Throwable {
		/*if (StringUtils.isEmpty(topicName)) {
			topicName = topic;
		}*/
		logs.info("state: " + state);
		//state = BEGIN;
		
		// true connected
		boolean conState = client.isConnected();
		if (!conState) {
			// Connect using a non-blocking connect
			MqttConnector con = new MqttConnector();
			con.doConnect();
			waitForStateChange(10000);
			
			// Subscribe using a non-blocking subscribe
			Subscriber sub = new Subscriber();
			sub.doSubscribe(topicName, qos);
			waitForStateChange(10000);
		} else {
			// Subscribe using a non-blocking subscribe
			Subscriber sub = new Subscriber();
			sub.doSubscribe(topicName, qos);
			waitForStateChange(10000);
		}
		
		
		
		
		// Use a state machine to decide which step to do next. State change occurs
		// when a notification is received that an MQTT action has completed
		/*while (state != FINISH) {
			switch (state) {
			case BEGIN:
				// Connect using a non-blocking connect
				MqttConnector con = new MqttConnector();
				con.doConnect();
				break;
			case CONNECTED:
				// Subscribe using a non-blocking subscribe
				Subscriber sub = new Subscriber();
				sub.doSubscribe(topicName, qos);
				break;
			case SUBSCRIBED:
				// Block until Enter is pressed allowing messages to arrive
				log("Press <Enter> to exit");
				try {
					System.in.read();
				} catch (IOException e) {
					// If we can't read we'll just exit
				}
				state = DISCONNECT;
				donext = true;
				break;
			case DISCONNECT:
				Disconnector disc = new Disconnector();
				disc.doDisconnect();
				break;
			case ERROR:
				throw ex;
			case DISCONNECTED:
				state = FINISH;
				donext = true;
				break;
			}

			// if (state != FINISH && state != DISCONNECT) {
			waitForStateChange(10000);
			// }
		}*/
		
	}

	public void disconnect() throws Throwable{
		System.out.print("start to disconnect");
		Disconnector disc = new Disconnector();
		disc.doDisconnect();
		waitForStateChange(10000);
	}

	/**
	 * Utility method to handle logging. If 'quietMode' is set, this method does
	 * nothing
	 * 
	 * @param message
	 *            the message to log
	 */
	void log(String message) {
		if (!quietMode) {
			logs.info(message);
		}
	}

	/****************************************************************/
	/* Methods to implement the MqttCallback interface */
	/****************************************************************/

	/**
	 * @see MqttCallback#connectionLost(Throwable)
	 */
	public void connectionLost(Throwable cause) {
		// Called when the connection to the server has been lost.
		// An application may choose to implement reconnection
		// logic at this point. This sample simply exits.
		logs.info(time());
		log("Connection to " + brokerUrl + " lost!" + cause);
		System.exit(1);
	}

	/**
	 * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
	 */
	public void deliveryComplete(IMqttDeliveryToken token) {
		// Called when a message has been delivered to the
		// server. The token passed in here is the same one
		// that was returned from the original call to publish.
		// This allows applications to perform asynchronous
		// delivery without blocking until delivery completes.
		//
		// This sample demonstrates asynchronous deliver, registering
		// a callback to be notified on each call to publish.
		//
		// The deliveryComplete method will also be called if
		// the callback is set on the client
		//
		// note that token.getTopics() returns an array so we convert to a string
		// before printing it on the console
		log("Delivery complete callback: Publish Completed " + Arrays.toString(token.getTopics()));
	}

	/**
	 * @see MqttCallback#messageArrived(String, MqttMessage)
	 */
	public void messageArrived(String topic, MqttMessage message) throws MqttException {
		TemSim tem_sim = new TemSim();
		byte[] payload = message.getPayload();
//		logs.info("加密的payload:\t" + new String(payload));
		
		// base64解密
		/*Decoder decoder = Base64.getDecoder();
		payload = decoder.decode(payload);
		*/

		String decoded = "";
		String serviceid = topic.toString().substring(4, 7);
		logs.info("service id = " + serviceid);
//		byte[] bytes = getBytesFrom(payload);

		try {
			decoded = new String(messageTransformer.uplinkTransform(FAKE_DEVICE_ID, serviceid, payload));
		} catch (Exception e) {
			logs.error("", e);
		}

		// Called when a message arrives from the server that matches any
		// subscription made by the client
		String time = new Timestamp(System.currentTimeMillis()).toString();
		if (!serviceid.equals("RVS")){
			logs.info("Time:\t" + time + "  Topic:\t" + topic + "  Message:\t" + new String(decoded)
					+ "  QoS:\t" + message.getQos());
		}

		// mqtt.subscribe.topic=RAW/POI/VIN1201

		if (StringUtils.isEmpty(topic)) {
			logs.error("topic is empty!");
			return;
		}

		tem_sim.ParasReceivedMessage(topic,decoded);

	}

	/**
	 * Connect in a non-blocking way and then sit back and wait to be notified that
	 * the action has completed.
	 */
	public class MqttConnector {

		public MqttConnector() {
		}

		public void doConnect() {
			// Connect to the server
			// Get a token and setup an asynchronous listener on the token which
			// will be notified once the connect completes
			logs.info(time());
			log("Connecting to " + brokerUrl + " with client ID " + client.getClientId());

			IMqttActionListener conListener = new IMqttActionListener() {
				public void onSuccess(IMqttToken asyncActionToken) {
					log("Connected");
					state = CONNECTED;
					carryOn();
				}

				public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
					ex = exception;
					state = ERROR;
					log("connect failed " + exception);
					carryOn();
				}

				public void carryOn() {
					synchronized (waiter) {
						donext = true;
						waiter.notifyAll();
					}
				}
			};

			try {
				// Connect using a non-blocking connect
				client.connect(conOpt, "Connect sample context", conListener);
			} catch (MqttException e) {
				// If though it is a non-blocking connect an exception can be
				// thrown if validation of parms fails or other checks such
				// as already connected fail.
				state = ERROR;
				donext = true;
				ex = e;
			}
		}
	}

	/**
	 * Publish in a non-blocking way and then sit back and wait to be notified that
	 * the action has completed.
	 */
	public class Publisher {
		public void doPublish(String topicName, int qos, byte[] payload) {
			// Send / publish a message to the server
			// Get a token and setup an asynchronous listener on the token which
			// will be notified once the message has been delivered
			MqttMessage message = new MqttMessage(payload);
			message.setQos(qos);

			String time = new Timestamp(System.currentTimeMillis()).toString();
			log("Publishing at: " + time + " to topic \"" + topicName + "\" qos " + qos);

			// Setup a listener object to be notified when the publish completes.
			//
			IMqttActionListener pubListener = new IMqttActionListener() {
				public void onSuccess(IMqttToken asyncActionToken) {
					log("Publish Completed");
					//state = PUBLISHED;
					carryOn();
				}

				public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
					ex = exception;
					state = ERROR;
					log("Publish failed" + exception);
					carryOn();
				}

				public void carryOn() {
					synchronized (waiter) {
						donext = true;
						waiter.notifyAll();
					}
				}
			};

			try {
				// Publish the message
				System.out.println("bengin send reponse message :"+message.toString());
				client.publish(topicName, message, "Pub sample context", pubListener);
			} catch (MqttException e) {
				e.printStackTrace();
				state = ERROR;
				donext = true;
				ex = e;
			}
		}
	}

	/**
	 * Subscribe in a non-blocking way and then sit back and wait to be notified
	 * that the action has completed.
	 */
	public class Subscriber {
		public void doSubscribe(String topicName, int qos) {
			// Make a subscription
			// Get a token and setup an asynchronous listener on the token which
			// will be notified once the subscription is in place.
			logs.info(time());
			log("Subscribing to topic \"" + topicName + "\" qos " + qos);

			IMqttActionListener subListener = new IMqttActionListener() {
				public void onSuccess(IMqttToken asyncActionToken) {
					log("Subscribe Completed");
					state = SUBSCRIBED;
					carryOn();
				}

				public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
					ex = exception;
					state = ERROR;
					log("Subscribe failed" + exception);
					carryOn();
				}

				public void carryOn() {
					synchronized (waiter) {
						donext = true;
						waiter.notifyAll();
					}
				}
			};

			try {
				client.subscribe(topicName, qos, "Subscribe sample context", subListener);
			} catch (MqttException e) {
				state = ERROR;
				donext = true;
				ex = e;
			}
		}
	}

	/**
	 * Disconnect in a non-blocking way and then sit back and wait to be notified
	 * that the action has completed.
	 */
	public class Disconnector {
		public void doDisconnect() {
			// Disconnect the client
			System.out.print("Disconnecting");

			IMqttActionListener discListener = new IMqttActionListener() {
				public void onSuccess(IMqttToken asyncActionToken) {
					log("Disconnect Completed");
					state = DISCONNECTED;
					carryOn();
				}

				public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
					ex = exception;
					state = ERROR;
					log("Disconnect failed" + exception);
					carryOn();
				}

				public void carryOn() {
					synchronized (waiter) {
						donext = true;
						waiter.notifyAll();
					}
				}
			};

			try {
				client.disconnect("Disconnect sample context", discListener);
			} catch (MqttException e) {
				state = ERROR;
				donext = true;
				ex = e;
			}
		}
	}

//	protected byte[] getBytesFrom(ByteBuf buf) {
//		byte[] bytes = new byte[buf.readableBytes()];
//		int readerIndex = buf.readerIndex();
//		buf.getBytes(readerIndex, bytes);
//		return bytes;
//	}
}
