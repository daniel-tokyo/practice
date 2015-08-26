#!/bin/sh
# $Id:$
# Created at: 2012-05-04 14:05:21
#-------------------------------------------------------------

usage() {
    echo "Usage:"
    echo "        `basename $0` < b | c | r args >"
    echo ""
}

if [ $# -eq 0 ]; then
    usage
    exit 1
fi

PATH_WORK='.'
PATH_SRC="${PATH_WORK}/src"
PATH_BIN="${PATH_WORK}/bin"

if [ $1 = 'b' ]; then
    rm -fr ${PATH_BIN}/*
    mkdir -p "${PATH_BIN}"
    javac ${PATH_SRC}/*.java -d "${PATH_BIN}" -Xlint
elif [ $1 = 'r' ]; then
    PATH_PWD="`pwd`"
    cd ${PATH_BIN}
    java Tester ${@:2}
    cd ${PATH_PWD}
elif [ $1 = 'c' ]; then
    rm -fr ${PATH_BIN}/*
else
    usage
    exit 2
fi

#{+----------------------------------------- Embira Footer 1.6 ---------+
# | vim<600:set et sw=4 ts=4 sts=4:                                     |
# | vim600:set et sw=4 ts=4 sts=4 ff=unix cindent fdm=marker fmr={,}:   |
# +---------------------------------------------------------------------+}
