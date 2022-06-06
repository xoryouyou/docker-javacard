FROM gradle:jdk8 
# include jcardsim and needed libs
ADD external /javacard
# change default dir
WORKDIR /applet
# switch to 'gradle' user
USER gradle
# presetup gradle
CMD bash