# TP7 – JMS avec ActiveMQ (LSI3 – Développement d'applications réparties)

**Étudiant(e) :** VotreNom Prénom

## Objectif
Mettre en œuvre une communication asynchrone producteur/consommateur via JMS (Topic) avec un broker ActiveMQ embarqué.

## Structure
- `BrokerStarter` : démarre le broker (tcp://0.0.0.0:61616)
- `JMSConsumer` : s'abonne au topic `TP7.TOPIC` avec un `MessageListener`
- `JMSProducer` : publie "Hello World! From: ..." (non persistant, session transactionnelle)

## Exécution
1. Lancer `BrokerStarter`
2. Lancer `JMSConsumer`
3. Lancer `JMSProducer`

## Captures d'écran
*(Insérer ici : console du broker, du consumer, du producer)*

## Synthèse
*(Expliquer : rôle du broker, modèle publish/subscribe, pourquoi le consumer doit démarrer avant le producer avec un Topic non durable, rôle de session.commit(), avantages de l'asynchrone.)*