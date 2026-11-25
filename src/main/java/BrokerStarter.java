import org.apache.activemq.broker.BrokerService;

/** Broker ActiveMQ embarqué */
public class BrokerStarter {
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.setPersistent(false);
        // 0.0.0.0 : écoute sur toutes les interfaces, port 61616
        broker.addConnector("tcp://0.0.0.0:61616");
        broker.start();
        System.out.println("Broker ActiveMQ démarré sur tcp://0.0.0.0:61616");
        broker.waitUntilStopped();
    }
}