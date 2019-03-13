/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var url_string = window.location.href; // www.test.com?filename=test
            var url = new URL(url_string);
            var paramValue = url.searchParams.get("error");
            if(paramValue == null){
                
            }
            else{
            alert("Wrong Username or Password")
        }
