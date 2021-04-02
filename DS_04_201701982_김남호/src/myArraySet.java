
public class myArraySet implements Set{
	private Object[] objects = new Object[1000];
	private int size, i;
	
	@Override
	public void add(Object object) {
		objects[size++] = object;
		return;
	}
	
	@Override
	public Boolean contains(Object object) {
		for(int j=0;j<size;j++) {
			if(objects[j].equals(object))
				return true;
		}
		return false;
	}
	
	@Override
	public Object getFirst() {
		i = 0;
		return objects[i++];
	}
	
	@Override
	public Object getNext() {
		return objects[i++];
	}
	
	@Override
	public Boolean remove(Object object) {
		int count=0;
		for(int j=0;j<size;j++) {
			if(objects[j].equals(object)) {
				System.arraycopy(objects, j+1, objects, j, size-j-1);
				objects[--size] = null;
				count++;
				j=0;
			}
		}
		if(count>0)return true;
		else return false;
	}
	
	@Override
	public int size() {
		return size;
	}
}
