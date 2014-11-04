package url;

import java.util.TreeMap;

public class Argument {
    private TreeMap<String, String> inputargs = new TreeMap<String, String>();
    private String s;
    
    
    /**
     * processing args and making in TreeMap
     */
    public void make(String[] mas) {
        int nums;
        String key = "";
        String value = "";
        for (int i = 0; i < mas.length; i++) {
            s = mas[i];
            nums = s.indexOf('=');
            key = s.substring(1, nums);
            value = s.substring(nums + 1, s.length());
            inputargs.put(key, value);
        }
    }

    /**
     * return value
     * 
     * @param k
     * @return value
     */
    public String makeprint(String k) {
        return inputargs.get(k);
    }
}
