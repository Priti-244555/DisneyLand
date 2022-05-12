//package pubsub;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	public static void main(String[] args) throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("testt");
		MessageProducer producer = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		message.setText("... sdtfghsWORLD");
		producer.send(message);
		System.out.println("Sent message : '" + message.getText() + "'");
		connection.close();
	}
}

