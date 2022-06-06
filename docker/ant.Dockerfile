FROM openjdk:8
# update and install ant
RUN apt-get -y update && apt-get install -y ant
# add non root user
RUN useradd -u 1000 javacard
# include jcardsim and needed libs
ADD external /javacard
# chown the libs
RUN chown -R javacard /javacard
# switch to the 'javacard' user
USER javacard
# change default dir
WORKDIR /applet
# open a shell
CMD bash