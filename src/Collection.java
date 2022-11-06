public interface Collection {
    boolean add (int index, String value) throws Exception;
    boolean add (String value);
    boolean delete (int index) throws Exception;
    boolean delete (String value);
    String get(int index) throws Exception;
}
