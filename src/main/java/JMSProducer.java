import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {
    public static void main(String[] args) throws Exception {
        String sender = "AICHA MASMOUDI";

        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();

        // Session transactionnelle + AUTO_ACKNOWLEDGE
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("TP7.TOPIC");
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        TextMessage message = session.createTextMessage("Hello World! From: " + sender);
        producer.send(message);

        // Indispensable : session transactionnelle => sans commit le message n'est pas envoyé
        session.commit();
        System.out.println("Message envoyé : " + message.getText());

        session.close();
        connection.close();
    }
}