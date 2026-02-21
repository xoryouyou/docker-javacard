# https://github.com/docker-library/openjdk/issues/505 
FROM eclipse-temurin:8
# include jcardsim and needed libs
ADD external /javacard
# change default dir
WORKDIR /applet
# presetup gradle
CMD ["bash"]