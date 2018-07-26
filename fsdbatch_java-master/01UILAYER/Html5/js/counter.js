/**
 * Created by Arun on 10/8/13.
 */


var   i=0;
function timedCount() {
    i=i+1;
    postMessage(i);
    setTimeout("timedCount()",1000);
}
timedCount();