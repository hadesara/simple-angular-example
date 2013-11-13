// @SOURCE:/Users/212357845/Desktop/Workspaces/simple angular example/conf/routes
// @HASH:086c2cbbbda542814fd1dde54622b2752163a52a
// @DATE:Sat Oct 26 13:24:22 PDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:7
package controllers {

// @LINE:16
// @LINE:13
class ReverseAssets {
    

// @LINE:16
// @LINE:13
def at(file:String): Call = {
   (file: @unchecked) match {
// @LINE:13
case (file) if file == "index.html" => Call("GET", _prefix)
                                                        
// @LINE:16
case (file) if true => Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:10
// @LINE:7
class ReverseWebJarAssets {
    

// @LINE:10
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                

// @LINE:7
def requirejs(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "lib/require.js")
}
                                                
    
}
                          
}
                  


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:7
package controllers.javascript {

// @LINE:16
// @LINE:13
class ReverseAssets {
    

// @LINE:16
// @LINE:13
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      if (file == """ + implicitly[JavascriptLitteral[String]].to("index.html") + """) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                        
    
}
              

// @LINE:10
// @LINE:7
class ReverseWebJarAssets {
    

// @LINE:10
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebJarAssets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

// @LINE:7
def requirejs : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.WebJarAssets.requirejs",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "lib/require.js"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
// @LINE:13
// @LINE:10
// @LINE:7
package controllers.ref {

// @LINE:16
// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:10
// @LINE:7
class ReverseWebJarAssets {
    

// @LINE:10
def at(file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebJarAssets.at(file), HandlerDef(this, "controllers.WebJarAssets", "at", Seq(classOf[String]), "GET", """ Enable webjar based resources to be returned""", _prefix + """webjars/$file<.+>""")
)
                      

// @LINE:7
def requirejs(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.WebJarAssets.requirejs(), HandlerDef(this, "controllers.WebJarAssets", "requirejs", Seq(), "GET", """ Obtain require.js with built-in knowledge of how webjars resources can be
 resolved""", _prefix + """lib/require.js""")
)
                      
    
}
                          
}
                  
      