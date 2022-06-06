FROM openjdk:8
# include jcardsim and needed libs
ADD external /javacard
# add all dependencies to run pcsc from the container
RUN apt-get -y update && apt-get install -y \
    ant \
    libpcsclite-dev \
    opensc \ 
    pcscd \
    pcsc-tools 

# change default dir
WORKDIR /applet
# start pcsc-daemon and jump into a shell
CMD service pcscd start && bash