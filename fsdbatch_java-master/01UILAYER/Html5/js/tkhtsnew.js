function techknow(){
if (window.File && window.FileReader && window.FileList && window.Blob) {
  // Great success! All the File APIs are supported.
  alert('Changed, Great success! All the File APIs are supported.');
} else {
  alert('Changed, The File APIs are not fully supported in this browser.');
}
}