(ns benchmark-tool.protocol)

(defprotocol DBprotocol
  (create-conn [db] "Create connection with db"))
