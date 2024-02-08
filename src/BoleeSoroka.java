public class BoleeSoroka {

        public static String trimToLength(String text, int length) {
            String result;
            if (text.length() > length) {
                result = text.substring(0, length) + "...";
                return result;
            }
            return text;
        }
    }