import java.util.Scanner;

public class NumberLetterConvertion {
  
       public static String InferiorVingt(int nb) {
   String str = new String();
           switch (nb) {
               case 0:
                   str = "zéro";
                   break;
               case 1:
                   str = "un";
                   break;
               case 2:
                   str = "deux";
                   break;
               case 3:
                   str = "trois";
                   break;
               case 4:
                   str = "quatre";
                   break;
               case 5:
                   str = "cinq";
                   break;
               case 6:
                   str = "six";
                   break;
               case 7:
                   str = "sept";
                   break;
               case 8:
                   str = "huit";
                   break;
               case 9:
                   str = "neuf";
                   break;
               case 10:
                   str = "dix";
                   break;
               case 11:
                   str = "onze";
                   break;
               case 12:
                   str = "douze";
                   break;
               case 13:
                   str = "treize";
                   break;
               case 14:
                   str = "quatorze";
                   break;
               case 15:
                   str = "quinze";
                   break;
               case 16:
                   str = "seize";
                   break;
               case 17:
                   str = "dix-sept";
                   break;
               case 18:
                   str = "dix-huit";
                   break;
               case 19:
                   str = "dix-neuf";
                   break;
               default:
                   break;
           }
   return str;
 }

 public static String InferiorCent(int nbre) {
   int modulo = 0, centaine = 0;
   String str = new String();
   if (nbre < 20)
     str = InferiorVingt(nbre);
   else if (nbre < 30) {
     modulo = nbre % 10;
     if (modulo == 0)
       str = "Vingt";
     else if (modulo== 1)
       str = "vingt et un";
     else
       str = "vingt-" + InferiorVingt(modulo);
   }
   else if (nbre < 40) {
	   modulo = nbre % 10;
	   switch (modulo) {
	       case 0:
	           str = "trente";
	       break;
		   case 1:
		       str = "trente et un";
		       break;
		   default:
	       str = "trente-" + InferiorVingt(modulo);
	           break;
	   }
   }
   else if (nbre < 50) {
	   modulo= nbre % 10;
       switch (modulo) {
           case 0:
               str = "quarante";
               break;
           case 1:
               str = "quarante et un";
               break;
           default:
               str = "quarante-" + InferiorVingt(modulo);
               break;
       }
   }
   else if (nbre < 60) {
     modulo = nbre % 10;
     if (modulo == 0)
       str = "cinquante";
     else if (modulo == 1)
       str = "cinquante et un";
     else
       str = "cinquante-"+InferiorVingt(modulo);
   }
   else if (nbre < 80) {
     modulo = nbre % 20;
       switch (modulo) {
           case 0:
               str = "soixante";
               break;
           case 1:
               str = "soixante et un";
               break;
           case 11:
               str = "soixante et onze";
               break;
           default:
               str = "soixante-" + InferiorVingt(modulo);
               break;
       }
   }
   else if (nbre < 100) {
     modulo = nbre % 20;
       switch (modulo) {
           case 0:
               str = "quatre-vingts";
               break;
           case 1:
               str = "quatre-vingt-un";
               break;
           default:
               str = "quatre-vingt-" + InferiorVingt(modulo);
               break;
       }
   }
   return str;
 }

 public static String InferiorMille(int nbre) {
   String str = new String();
   int centaine = 0, cents = 0;
   if (nbre < 100)
     str =InferiorCent(nbre);
   else if (nbre < 1_000) {
     centaine = nbre % 100;
     cents = nbre / 100;
     if (cents == 1) {
       if (centaine == 0)
         str ="cent";
       else
         str ="cent " + InferiorCent(centaine);
     }
     else {
       if (centaine == 0)
         str =InferiorCent(cents) + " cents";
       else
         str =InferiorCent(cents) + " cent " + InferiorCent(centaine);
     }
   }
   return str;
 }

 public static String InferiorMillion(int nbre) {
   String str = new String();
   int millieme = 0, miles = 0;
   if (nbre < 1_000)
     str = InferiorMille(nbre);
   else {
     millieme = nbre % 1_000;
     miles = nbre / 1_000;
     if (miles == 1) {
       if (millieme == 0)
         str = "mille";
       else
         str = "mille " + InferiorMille(millieme);
     }
     else if(miles < 1_000) {
       if (millieme == 0)
         str = InferiorMille(miles) + " mille";
       else
         str = InferiorMille(miles) + " mille " + InferiorMille(millieme);
     }
   }
   return str;
 }
 public static String InferiorMilliard(int nbre){
   String str = new String();
   int lesMillions = 0, million = 0;
   if (nbre < 1_000_000)
     str = InferiorMillion(nbre);
   else if (nbre < 1_000_000_000) {
     million = nbre % 1_000_000;
     lesMillions = nbre / 1_000_000;
     if (lesMillions == 1) {
       if (million == 0)
         str =InferiorMillion(lesMillions) + " million";
       else
         str =InferiorMillion(lesMillions) + " million " + InferiorMillion(million);
     }
     else {
       if (million == 0)
         str = InferiorMillion(lesMillions) + " millions";
       else
         str = InferiorMillion(lesMillions) + " millions " + InferiorMillion(million);
     }
   }
   return str;
 }

 public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("TAPEZ UN NOMBRE COMPRIS ENTRE 0 ET 1000000000:");
        int nbre = 0;
        try{
            nbre = sc.nextInt();
        }catch(java.util.InputMismatchException e){
            System.out.println("Vous avez dépassé la capacité de stockage du type 'int' ");
        }
        while( nbre < 0 && nbre > 1_000_000_000){
            System.out.println("NB: Ce nombre doit être compris dans l'intervalle fermé de 0 à 1.000.000.000\n\nLe nombre est: ?");
            nbre = sc.nextInt();
        }
        if(nbre < 100)
            System.out.println(InferiorCent(nbre));
        else if (nbre < 1_000)
            System.out.println(InferiorMille(nbre));
        else if (nbre < 1_000_000)
            System.out.println(InferiorMillion(nbre));
        else if(nbre < 1_000_000_000)
            System.out.println(InferiorMilliard(nbre));
        else if (nbre == 1_000_000_000)
            System.out.println("Un milliard");
    }
}
