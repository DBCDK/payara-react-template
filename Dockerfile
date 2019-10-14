FROM docker.dbc.dk/payara5-micro:latest

LABEL INSTANCE="Name of the instance of this payara react example. Typically the name of the environment e.g. FBStest"

USER root

COPY payara-react-api/target/payara-react-api-*.war app.json deployments/