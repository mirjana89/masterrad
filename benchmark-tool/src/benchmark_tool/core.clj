(ns benchmark-tool.core
  (:require [benchmark-tool.protocol :as protocol]
            [benchmark-tool.db.datomic :as datomic]))

;set priority of the current thread (Thread/MAX_PRIORITY)
(defn set-thread-priority 
  [priority]
  (.setPriority (Thread/currentThread) priority))

;(protocol/create-conn (datomic/->DatomicDB datomic/uri))

;OLTP operations:
; read = write
; data size in range of tens of kilobytes
;3x32bit int + 3xfloat + 3xtext(100chars) + 1xsmallblob(32,768)
; 32 record =1mb of data
; 160 records = 5mb of data

;Web2.0 operations:
;read = 500*write
;data size in range of megabytes
;1x32int + 5xtext(500chars) + 1xlargeblob(5,241,346)

;OLAP operations:
;reads = 100*write
;data size in range of kilobytes
;10x32int + 10xfloat + 7xtext(132chars)
