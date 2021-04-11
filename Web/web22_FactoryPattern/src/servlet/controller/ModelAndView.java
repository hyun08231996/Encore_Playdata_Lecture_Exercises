package servlet.controller;
/*
 * 결과 페이지의 이름과
 * 이동방식(forward | redirect)에 대한 정보를
 * 담고 있는 객체
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;//forward일 확율이 80%이기 때문에, isForward를 사용하지 않고 isRedirect의 기본값을 false로 지정한다
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {
		super();
	}
	public ModelAndView(String path) {
		super();
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
