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
./build/install/app/bin/app file1.json file2.json
```

### Сравнение двух YAML-файлов
```bash
./build/install/app/bin/app file1.yaml file2.yaml
```

### Справочная информация
```bash
./build/install/app/bin/app -f
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
├── README.md
└── app
    ├── Makefile
    ├── build.gradle.kts
    ├── config
    │   └── checkstyle
    │       ├── checkstyle.xml
    │       └── checkstyle.xml:Zone.Identifier
    ├── gradle
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle.kts
    └── src
        ├── main
        │   ├── java
        │   │   └── hexlet
        │   │       └── code
        │   │           ├── App.java
        │   │           ├── Differ.java
        │   │           └── Parser.java
        │   └── resources
        └── test
            ├── java
            │   └── DifferTest.java
            └── resources
                ├── empty_file1.json
                ├── empty_file2.json
                ├── expected_all_types.txt
                ├── expected_empty.txt
                ├── expected_result.txt
                ├── expected_same_files.txt
                ├── file1.json
                ├── file2.json
                ├── file_all_types1.json
                └── file_all_types2.json
```