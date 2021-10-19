import java.util.ArrayList;

public class PrettyJson {

        public  static ArrayList<String> prettyJSON(String a) {
            ArrayList<String> result = new ArrayList<String>();
            int tabCounter = 0;
            StringBuffer current = new StringBuffer();
            for(int i=0; i<a.length(); i++) {
                char c = a.charAt(i);
                switch(c) {
                    case '{':
                    case '[':
                        if(current.length() > 0) {
                            result.add(current.toString());
                            current = new StringBuffer();
                        }
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                        current.append(c);
                        result.add(current.toString());
                        current = new StringBuffer();
                        tabCounter++;
                        System.out.println("In {[ block current"+current );
                        System.out.println("In {[ block result"+result  );
                        System.out.println("In {[ block tabCounter"+tabCounter );
                        System.out.println("In {[ block Char"+c);
                        break;

                    case ']':
                    case '}':
                        if(current.length() > 0) {
                            result.add(current.toString());
                            current = new StringBuffer();
                        }
                        tabCounter--;
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                        current.append(c);
                        System.out.println("In ]} block"+current );
                        System.out.println("In ]} block result"+result  );
                        System.out.println("In ]} block tabcounter"+tabCounter );
                        System.out.println("In ]} block Char"+c);
                        break;

                    case ',':
                        current.append(c);
                        result.add(current.toString());
                        current = new StringBuffer();
                        System.out.println("In , block current"+current);
                        System.out.println("In , block result "+result);
                        System.out.println("In , block Char"+c);
                        break;

                    default:
                        if(current.length() == 0) {
                            for(int j=0; j<tabCounter; j++) {
                                current.append('\t');
                            }
                        }
                        current.append(c);
                        System.out.println("In default block current "+current );
                        System.out.println("In default block char "+c);
                }
            }

            if(current.length() > 0) {
                result.add(current.toString());
            }

            return result;
        }
        public static void main(String[] args){
            String A="{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
            ArrayList<String> result=prettyJSON(A);
            for(int i=0;i<result.size();i++){
                System.out.println("Pretty JSON"+result.get(i));
            }
        }
    }



