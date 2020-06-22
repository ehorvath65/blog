#!/bin/bash
echo -ne '\n' | ./psql-blog-restart.sh
echo -ne '\n' | ./psql-blog-insertions.sh
./psql-meseblog-add-post-bevezeto.sh
./psql-meseblog-add-post-anyak.sh
./psql-meseblog-add-post-hazassag.sh
echo -ne '\n' | ./psql-blog-show.sh
