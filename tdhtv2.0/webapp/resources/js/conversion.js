 
function  intToByte(number)
  {
    var byteNumber = [];  
        var  check = 1;
            for (var i=0; i<8;i++)
            { 
            var K = number & check;

                if (K==0)
                {
                    byteNumber[i] = 0;
                }
                else 
                {
                    byteNumber[i] = 1;
                }
          
               check=   check << 1;
            }
			
			return byteNumber;
  }

  
  
   function  byteToInt(byteNumber)
  {
  
            var number = 0;

            for (var i = 0; i <8; i++)
            {
                number = (number + byteNumber[i] * Math.pow(2, i));//
            }

            return number;
  }
