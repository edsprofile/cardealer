package com.example.cardealer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

public class CassandraConnector {
	private Cluster cluster;
	private Session session;
	
	public void connectDefault() {
		Builder b = Cluster.builder().addContactPoint("127.0.0.1");
		b.withPort(9042);
		
		cluster = b.build();
		session = cluster.connect();
	}
	
	public void connect(String node, Integer port) {
		Builder b = Cluster.builder().addContactPoint(node);
		
		if(port != null) {
			b.withPort(port);
		}
		
		cluster = b.build();
		session = cluster.connect();
	}
	
	public Session getSession() {
		return this.session;
	}
	
	public void close() {
		session.close();
		cluster.close();
	}
	
	public void createKeyspace(String keyspaceName, String replicationStrategy, int replicationFactor) {
		StringBuilder sb = new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
				.append(keyspaceName)
				.append(" WITH replication = {'class': '")
				.append(replicationStrategy)
				.append("', 'replication_factor': '")
				.append(replicationFactor)
				.append ("'} AND durable_writes ='true';");
		
		String query = sb.toString();
		session.execute(query);
	}
	
	public void useKeyspace(String keyspace) {
		session.execute("USE " + keyspace);
	}
}
