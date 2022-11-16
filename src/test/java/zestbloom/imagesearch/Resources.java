package zestbloom.imagesearch;

public interface Resources {

   boolean uploadImage();
   boolean searchImage();
   boolean searchImage(int id);
   boolean searchAsset();
   boolean searchAsset(int id);
   boolean searchByText();
   boolean searchByText(String text);
   boolean searchImage(String text);
}
