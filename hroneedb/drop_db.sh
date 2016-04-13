




echo $PATH
DB_PATH=/tmp/applifire/db/GAXOUHJGYGAS0P2YI6VSIG/9AB8B7C9-7739-48CA-88C4-35A7176BFF39
MYSQL=/usr/bin
USER=anagha
PASSWORD=anagha
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'