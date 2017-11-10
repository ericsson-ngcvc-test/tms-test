package csptest.FunctionFactory.common.dbFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * @author jiayong.zou
 */
public class cassandradbopr {

//	private String addiSignalsKey = "AddiSignals";
//	private String msdSignalsKey = "MSDSignals";

	public static String Selectdb(String ip, String username, String password, String keyspace, String oprsql) {
		Session session = getsession(ip, username, password, keyspace);
		ResultSet resultSet = session.execute(oprsql);
		Iterator<Row> rsIterator = resultSet.iterator();
		int i = 0;  //行计数
		
			
		StringBuilder SB =new StringBuilder(); // save result
		
		
		while (rsIterator.hasNext()) {
			int l=0; 
			int j = 0;//获取列数:
			Row row = rsIterator.next();
			for (ColumnDefinitions.Definition definition1 : row.getColumnDefinitions()) {
				l++;
				}
		//	System.out.println(row);
			for (ColumnDefinitions.Definition definition : row.getColumnDefinitions()) {
				;	//列计数
				String columnname = definition.getName();
			//	coLlist.add(columnname);
			//	System.out.println(columnname);
				// //首先需要判断字段的类型再用对应的取值函数去取值,有些麻烦
				DataType columntypes = definition.getType();
				String columntype = columntypes.getName().toString();
				Object columnvalue = "";
				if (columntype.equals("ascii")) {
					columnvalue = row.getString(columnname).toString();

				} else if (columntype.equals("bigint")) {
					columnvalue = row.getLong(columnname) + "";

				} else if (columntype.equals("blob")) {
					columnvalue = row.getBytes(columnname) + "";

				} else if (columntype.equals("boolean")) {
					columnvalue = row.getBool(columnname) + "";

				} else if (columntype.equals("counter")) {
					columnvalue = row.getLong(columnname) + "";

				} else if (columntype.equals("date")) {
					columnvalue = row.getDate(columnname) + "";

				} else if (columntype.equals("decimal")) {
					columnvalue = row.getDecimal(columnname) + "";

				} else if (columntype.equals("double")) {
					columnvalue = row.getDouble(columnname) + "";

				} else if (columntype.equals("float")) {
					columnvalue = row.getFloat(columnname) + "";

				} else if (columntype.equals("inet")) {
					columnvalue = row.getInet(columnname) + "";

				} else if (columntype.equals("int")) {
					columnvalue = row.getInt(columnname) + "";

				} else if (columntype.equals("list")) {
					List<String> colvalues = row.getList(columnname, String.class);
					int k = 0;
					while (k < colvalues.size()) {
						columnvalue = columnvalue + colvalues.get(k);
						k++;
					}

				} else if (columntype.equals("map")) {
					HashMap<String, String> colvaluess = (HashMap<String, String>) row.getMap(j, String.class,
							String.class);
					columnvalue = transMapToString(colvaluess);

				} else if (columntype.equals("set")) {
					HashSet<String> hSet = (HashSet<String>) row.getSet(columnname, String.class);
					columnvalue = transSetToString(hSet);

				} else if (columntype.equals("smallint")) {
					columnvalue = row.getShort(columnname) + "";

				} else if (columntype.equals("text")) {
					columnvalue = row.getBytes(columnname) + "";

				} else if (columntype.equals("time")) {
					columnvalue = row.getTime(columnname) + "";

				} else if (columntype.equals("timestamp")) {
					columnvalue = row.getTimestamp(columnname) + "";

				} else if (columntype.equals("timeuuid")) {
					columnvalue = row.getUUID(columnname) + "";

				} else if (columntype.equals("tinyint")) {
					columnvalue = row.getBytes(columnname) + "";

				} else if (columntype.equals("tuple  ")) {
					columnvalue = row.getTupleValue(columnname) + "";

				} else if (columntype.equals("user-definedtypes")) {
					columnvalue = row.getUDTValue(columnname) + "";

				} else if (columntype.equals("uuid")) {
					columnvalue = row.getUUID(columnname) + "";

				} else if (columntype.equals("varchar")) {
					columnvalue = row.getString(columnname) + "";

				} else if (columntype.equals("varint")) {
					columnvalue = row.getVarint(columnname) + "";

				}
				//System.out.println(columnname+columnvalue);
				//System.out.println(SB);
				if(j<l-1){					
					SB.append(columnname).append(":").append(columnvalue.toString()).append(",");
	
				}else{
					SB.append(columnname).append(":").append(columnvalue.toString());
				}
		//	System.out.println(SB);
				j++;
			}
			SB.append("\n");
			i += i;	
			//System.out.println(SB);
		}
			
		return SB.toString();	
	}
/*
	private HashMap<String, Item> transToMap(List<String> cols, ResultSet rs) {
		HashMap<String, Item> ret = new HashMap<String, Item>();
		Iterator<Row> it = rs.iterator();

		String updatedTimeKey = "updatedtime";
		while (it.hasNext()) {
			Row row = it.next();

			// last update time
			Object updatedTime = row.getObject(updatedTimeKey);
			if (updatedTime != null && updatedTime instanceof Date) {
				Item item = new Item();
				item.setTimestamp((Date) updatedTime);
				item.setValue(updatedTime);
				ret.put(updatedTimeKey, item);
			}

			for (String key : cols) {
				String resKey = key;
				Object value = row.getObject(resKey);
				Object timestamp = row.getObject(resKey + "_ts");

				// null value don't need to be added
				if (value == null) {
					continue;
				}

				Item resItem = new Item();
				// updatedTime
				if (timestamp != null && timestamp instanceof Date) {
					// timestamp
					resItem.setTimestamp((Date) timestamp);
				}

				if ((addiSignalsKey.equalsIgnoreCase(key) || msdSignalsKey.equalsIgnoreCase(resKey))
						&& value instanceof Map) {
					Map<String, String> smap = (Map) value;
					List signals = new LinkedList<>();
					for (String o : smap.values()) {
						signals.add(JsonUtils.parseJsonToObject(o, Map.class));
					}
					value = JsonUtils.toJsonString(signals);
				}

				// sensor info is not need in reading status
				// resItem.setSensorName();
				resItem.setValue(value);
				ret.put(resKey, resItem);
			}
		}
		return ret;
	}
*/
	public static Session getsession(String ip, String username, String password, String keyspace) {
		Session session = null;
		Cluster cluster = null;

		if (null == session) {
			try {

				if (null == session) {
					cluster = Cluster.builder().addContactPoint(ip).withCredentials(username, password).build();
					session = cluster.connect(keyspace);
				}
			} finally {

				// lock.unlock();
				// cluster.close();
			}
		}
		return session;

	}

	public static void clusterclose(Cluster cluster) {
		cluster.close();
	}

	public static String transMapToString(Map<String, String> map) {
		java.util.Map.Entry entry;
		StringBuffer sb = new StringBuffer();
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			entry = (java.util.Map.Entry) iterator.next();
			sb.append(entry.getKey().toString()).append("'")
					.append(null == entry.getValue() ? "" : entry.getValue().toString())
					.append(iterator.hasNext() ? ":" : "");
		}
		return sb.toString();
	}

	public static String transSetToString(HashSet<String> sets) {
		String userStr = "";
		Iterator<String> iterator = sets.iterator();
		while (iterator.hasNext()) {
			userStr += iterator.next() + ",";
		}
		userStr = userStr.substring(0, userStr.length() - 2);
		return userStr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ./cqlsh 172.21.36.174 9042 -u cassandra -p cassandra -k m2m;
		String ip = "172.21.36.174";
		String username = "cassandra";
		String password = "cassandra";
		String keyspace = "m2m";
	//	String selectsql = "select * from student";
		String selectsql = "select * from history_status where vin='000000test-103684'";
		String result = cassandradbopr.Selectdb(ip, username, password, keyspace, selectsql);
		System.out.println(result);
	}

	/*
	 * CQL数据类型Java数据类型的对应关系表 CQL3 data type Getter name Java type ascii
	 * getString java.lang.String bigint getLong long blob getBytes
	 * java.nio.ByteBuffer boolean getBool boolean counter getLong long date
	 * getDate LocalDate decimal getDecimal java.math.BigDecimal double
	 * getDouble double float getFloat float inet getInet java.net.InetAddress
	 * int getInt int list getList java.util.List map getMap java.util.Map set
	 * getSet java.util.Set smallint getShort short text getString
	 * java.lang.String time getTime long timestamp getTimestamp java.util.Date
	 * timeuuid getUUID java.util.UUID tinyint getByte byte tuple getTupleValue
	 * TupleValue user-defined types getUDTValue UDTValue uuid getUUID
	 * java.util.UUID varchar getString java.lang.String varint getVarint
	 * java.math.BigInteger
	 * 
	 */

}
