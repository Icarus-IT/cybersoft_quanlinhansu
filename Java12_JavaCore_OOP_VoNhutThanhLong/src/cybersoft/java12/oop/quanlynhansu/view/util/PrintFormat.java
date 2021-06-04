package cybersoft.java12.oop.quanlynhansu.view.util;

public class PrintFormat {
	/*
	 * Các thuộc tính, phương thức
	 * thuộc mức đối tượng (ko static)
	 * -> chỉ sử dụng được khi
	 * đã khởi tạo instance
	 * 
	 * Các thuộc tính, phương thức
	 * thuộc mức lớp (static)
	 * -> có thể sử dụng mà không
	 * cần phải khởi tạo instance
	 */
	public static final String HEADER_FORMAT
		= "|%5s |%10s |%20s |%15s |%10s |%15s |%15s |%15s |%35s |\n";
	public static final String BODY_FORMAT 	
		= "|%5d |%10d |%20s |%15s |%11.0f |%15.0f |%15.0f |%15s |%35s |\n";
	public static final String BOTTOM_FORMAT
		= "|%86s |%15.0f |%52s |\n";
}
