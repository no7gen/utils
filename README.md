# utils
utils for any tasks

## DB
Собраны команды и файлы для запуска разных баз.
### oracle11
Содержит docker-compose файл для запуска оракла11 в докере.
### postgres13
Можно запустить в докере командой:  
`docker run --name nogen-pg-test-13.3 -p 5432:5432 -e POSTGRES_USER=testuser -e POSTGRES_PASSWORD=testpass -e POSTGRES_DB=pgtest -d postgres:13.3`  
Добавил docker-compose with persist. db/postgres/template
