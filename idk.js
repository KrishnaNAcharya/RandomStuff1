//let a={
    //'first_name': 'Jon',
//};
//const a=5;
//a=6;
//try {

  //  a={
     //   first_name:'Jon'
   // }
//}catch(err){
   // console.log(err.message);
//}

//console.log(typeof a);
//let a=false;
//console.log(typeof a);

const a=['a','e','f'];
const b=a.join(' -- ');
let c='';
for (i=0; i<a.length;i++){
    c-c+a[i]+' == ';
}
console.log(b);
console.log(typeof b);
console.log(c);

a.forEach(ele => {
  ele=ele+'changed'
  console.log(ele);
  return ele;
})

comsole.log(a);
console.log('--------');
for( const ele of a){
  console.log(ele);
}