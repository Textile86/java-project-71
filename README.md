# Java Differ

[![Java CI](https://github.com/Textile86/java-project-71/actions/workflows/differ.yml/badge.svg)](https://github.com/Textile86/java-project-71/actions/workflows/differ.yml)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Textile86_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Textile86_java-project-71)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Textile86_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Textile86_java-project-71)

[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Textile86_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Textile86_java-project-71)

[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Textile86_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Textile86_java-project-71)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Textile86_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Textile86_java-project-71)


## Возможности:

- Сравнение JSON-файлов
- Сравнение YAML-файлов
- Форматы вывода: stylish, plain, json

## Демонстрация работы:
[![asciicast](https://asciinema.org/a/ACRUX2LLOrnEMEIAHc7LYogDa.svg)](https://asciinema.org/a/ACRUX2LLOrnEMEIAHc7LYogDa)

## Установка:
```bash
git clone https://github.com/your-username/java-project-71.git
cd java-project-71/app
./gradlew installDist
```

## Использование:

### Сравнение двух JSON-файлов
```bash
app file1.json file2.json
```

```bash
app -f json file1.json file2.json
```

### Сравнение двух YAML-файлов
```bash
app file1.yaml file2.yaml
```

```bash
app -f plain nested_yaml_file1.yaml nested_yaml_file2.yaml
```

### Справочная информация
```bash
app -f
```

## Развертывание программы

### Установка
```bash
make setup
```

### Билд
```bash
make build
```

### Запуск
```bash
make run
```

### Тесты
```bash
make test
```

### Линтер
```bash
make lint
```

### Обновить
```bash
make update
```

### Структура проекта
```
.
├── build.gradle.kts              # Конфигурация Gradle
├── gradlew                       # Gradle wrapper
├── settings.gradle.kts           # Настройки проекта
├── src
│   ├── main
│   │   └── java
│   │       └── hexlet
│   │           └── code
│   │               ├── App.java              # Главный класс (picocli)
│   │               ├── Differ.java           # Логика сравнения файлов
│   │               ├── Formatter.java        # Фабрика форматеров
│   │               ├── Parser.java           # Парсер JSON/YAML
│   │               └── formatters
│   │                   ├── JsonFormatter.java    # JSON форматтер
│   │                   ├── PlainFormatter.java   # Plain форматтер  
│   │                   └── StylishFormatter.java # Stylish форматтер
│   └── test
│       ├── java
│       │   └── DifferTest.java           # Тесты
│       └── resources
│           ├── file1.json                # Тестовые файлы
│           ├── file2.json
│           ├── expected_*.txt           # Ожидаемые результаты
│           └── ...
├── build
│   └── install
│       └── app
│           └── bin
│               └── app                  # Исполняемый файл
└── README.md                           # Документация
```