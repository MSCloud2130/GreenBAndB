FROM jenkins/jenkins:alpine

ENV JENKINS_USER=admin
ENV JENKINS_PASS=admin
ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false


ADD plugins.txt .
RUN jenkins-plugin-cli -f plugins.txt
ADD ssh-config .
USER root
ADD start.sh .

RUN apk add rsync
RUN mkdir /deploy
RUN mkdir /deploy/users
RUN mkdir /deploy/billing
RUN mkdir /deploy/productsrest
RUN mkdir /deploy/productssoap

RUN chown -R jenkins:jenkins /deploy

USER jenkins
ENTRYPOINT ["/start.sh"]
