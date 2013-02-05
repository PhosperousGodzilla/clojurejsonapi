## Running

To start a web server for the application, navigate to the folder and run:

    lein ring server

the web app will start up on port 3005 (configurable in project.clj)



## Details

Navigating to `http://localhost:3005/add` will succesfully show the JSON converted from map `my-data` `from crud.clj`
and the page displays this: 

    {
      "foo" : "bar",
      "people" : {
        "age" : 6,
        "name" : "riding hood",
        "attr" : "red scarf"
      },
      "wolf" : 1
    }
    
The original map that was converted from is 

    (def my-data {:foo "bar" :wolf 1 :people {:name "riding hood" :attr "red scarf" :age 6}})
    
this is in the `crud.clj` right below `ns` 


## Problem

Posting json data to the application doesn't work

Using CURL: 

    curl -X POST -H "Content-Type: application/json" -d '{"foo":"bar","baz":5}' http://localhost:3005/add
    
this seems to throw an error.  When posting from fiddler, `:params` are always empty `{}` and the request turns to alert icon
as stating a `bad request`

