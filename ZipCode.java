// EPIC FAILURE while retriving correct data -_- 
// lets consider from zip code can be of length 10 or 9 depending upon if it contains a special character -

public Boolean isZipCode(String zipCode) {
   int lenZipCode = zipCode.length();
   for(int i=0; i< lenZipCode; i++) {
         if(!((zipCode.charAt(i)<='0' && zipCode.charAt(i)>='9' )  {
            if(i!=5) return false;
         }

 if(zipCode.chartAt(i)=='-' && i!=5 )
         return false;

}
if(zipCode.contains('-')) {
      if(lenZipCode==10) return true;
      else return false;
} else {
      if(lenZipCode==9) return true;
      else return false;
}
}

// use assert to check if there is 5 letter before and after 
// where was the problem in thinking?
// 1. Use Inclusion and exclusion principle, exclude the possibilities and include the possiblilies 
// 2. Get the exclusion ideas through asking queries and write them down infront of whoever asking so you don't forget neither they  -_=
// 3. Exclude those and check corner cases 
// 4. When matching a pattern use REGEX =_= when you have used REGEX thousand times before
