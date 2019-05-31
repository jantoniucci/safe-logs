# SafeLogs
> Be safe at accessing production logs without personal information or secrets.

This tool is intended to extract personal information or secrets from production logs. It could be parametrised but also personalised and extended through a component model.

### from:
```
64.242.88.10 - - [28/May/2019:16:06:51 +0100] Accesing using username jantoniucci and password aaa
64.242.88.10 - - [28/May/2019:16:06:51 +0100] Credit card 1234-5678-9012-3456 from Javier Antoniucci
64.242.88.10 - - [28/May/2019:16:06:52 +0100] Sending a message 'Dear David, I am planning to go to New York next week, Best, Javier Antoniucci' using an internal notification
64.242.88.10 - - [28/May/2019:16:06:52 +0100] Sending from jantoniucci@test.com to david@test2.com
64.242.88.10 - - [28/May/2019:16:06:52 +0100] Accessing from 127.0.0.1:8080 and proxy 192.168.0.250
64.242.88.10 - - [28/May/2019:16:06:53 +0100] A new message was received by 'Juan Perez' from Soda Company Inc with an attachment
```
### to:
```
[IPADDRESS] - - [28/May/2019:16:06:51 +0100] Accessing using [USERNAME] and [PASSWORD]
[IPADDRESS] - - [28/May/2019:16:06:51 +0100] Credit card [CREDITCARD] from [NAME]
[IPADDRESS] - - [28/May/2019:16:06:52 +0100] Sending a message 'Dear [NAME], I am planning to go to [LOCATION] next week, Best, [NAME]' using an internal notification
[IPADDRESS] - - [28/May/2019:16:06:52 +0100] Sending from [EMAIL] to [EMAIL]
[IPADDRESS] - - [28/May/2019:16:06:52 +0100] Accessing from [IPADDRESS] and proxy [IPADDRESS]
[IPADDRESS] - - [28/May/2019:16:06:53 +0100] A new message was received by '[NAME]' from [ORGANIZATION] with an attachment
```
The core processor is isolated from source and target persistence. The default source/target are files but it could be easily extended to support kafka topics, elastic search collections, etc.

Performance is a concern, but a raw test shows it processing 100,000 lines (12MB) / minute using 1 vCPU.

## Installation
### pre-requisites
* [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
* [java 8](https://openjdk.java.net/install/)
### clone & build
```sh
git clone https://github.com/jantoniucci/safe-logs.git
cd safe-logs
./gradlew install
```

## Usage example

```sh
./gradlew run --args='./examples/example.log ./examples/example.sanitized.log'
```

## Release History

* 0.0.3
    * Core system : replace organizations by a tag

* 0.0.2
    * Core system : replace locations by a tag

* 0.0.1
    * Documentation : this README.md
    * Core system : replace names by a tag
    * I/O : file input & output
    * Execution support : command line interface

## Roadmap

* 0.1.0
    * Core system : regexp support
    * RegExp : adds several usefull pre-defined regexp
    * Execution support : adds more params to the command line interface

* 0.2.0
    * Core system : extension model and file based configuration
    * Execution support : adds more params to the command line interface

* Evolution
    * Core system : optimisation
    * I/O : support for kafka topics
    * Execution support : kafka connect

## Meta

Javier Antoniucci – [@jantoniucci](https://twitter.com/jantoniucci) – javier.antoniucci@gmail.com

Distributed under the MIT license. See ``LICENSE`` for more information.

### Project structure

* examples : files to be used as examples
* src : source code

## Contributing

1. Fork it (<https://github.com/jantoniucci/safe-logs/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
