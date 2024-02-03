let a={
    'first_name': 'Jon',
};
//const a=5;
//a=6;
try {
    a={
        first_name:'Jon'
    }
}catch(err){
    console.log(err.message);
}

console.log(typeof a);