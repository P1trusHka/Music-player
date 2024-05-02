# Используем официальный образ OpenJDK
FROM openjdk:11-jdk

# Устанавливаем переменную окружения для версии Gradle
ENV GRADLE_VERSION=7.0

# Загружаем и устанавливаем Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip -q gradle-${GRADLE_VERSION}-bin.zip -d /opt \
    && rm gradle-${GRADLE_VERSION}-bin.zip

# Устанавливаем переменную окружения для Gradle
ENV GRADLE_HOME /opt/gradle-${GRADLE_VERSION}
ENV PATH $PATH:/opt/gradle-${GRADLE_VERSION}/bin

# Копируем файлы проекта в Docker-контейнер
COPY . /app

# Устанавливаем рабочую директорию
WORKDIR /app

# Собираем проект с помощью Gradle
RUN gradle build

# Команда для запуска приложения (замените на свою)
CMD ["java", "-jar", "build/libs/untitled7-1.0-SNAPSHOT.jar"]