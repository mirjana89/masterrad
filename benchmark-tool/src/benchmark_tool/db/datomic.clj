(ns benchmark-tool.db.datomic
  (:use [datomic.api :only [db q] :as d])
  (:require [benchmark-tool.protocol :as protocol]))

(def uri "datomic:free://localhost:4334/benchmarkdb")

;;only the first time
(d/create-database uri)

;(def conn (d/connect uri))

;;Only the first time
;@(d/transact conn (read-string (slurp "lastfm-schema.dtm")))

(defrecord DatomicDB [uri]
  protocol/DBprotocol
  (create-conn [this] (d/connect uri)))
