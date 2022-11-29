package enitities.inventoryEntities;


public interface IInventory {
	public String getNameOfItem(int id) throws Exception;

	public int getCountOfItems();
	public int getCountOfItem(int id) throws Exception;
	public int getPowerOfItem(int id) throws Exception;

	public void setCountOfItems(int id, int newCounts) throws Exception;
}