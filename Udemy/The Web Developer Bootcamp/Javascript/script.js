/*var firstName = prompt("What is your Name?")
var surName = prompt("What is your surname?");
var age = prompt("What is your age?");

console.log("Your FULL name is "+firstName+" "+surName);
console.log("Your age is "+age);
*/

$( document ).ready(function() {
    
}
);

var createPet = function(name) {
    var sex;

    return {
        
        //name: name,
        //sex: sex,
        setName: function(newName) {
            name = newName;
        },
        getName: function() {
            return name;
        },
        getSex: function() {
            return sex;
        },
        setSex: function(newSex) {
            if(typeof(newSex) === "string" && (newSex.toLowerCase() === "male" || newSex.toLowerCase() === "female"))
                sex = newSex;
        }
    };
}

var pet = createPet('Venya');
var pet2 = createPet('Penya');
console.log(pet);
console.log(pet2);

pet.setSex("male");
pet2.setSex("female");

console.log(pet.getName());
console.log(pet.getSex());
console.log(pet2.getName());
console.log(pet2.getSex());

var secureCode = "SUGAR";

var getCode = function(part2){
    secureCode;
    return function (token) {
      return secureCode+"_"+part2+"_" + token;
    };
  };

var gcf1 = getCode('part2_1');
secureCode = "SUGAR55555";
var gcf2 = getCode('part2_2');

console.log(gcf1());
console.log(gcf2());

