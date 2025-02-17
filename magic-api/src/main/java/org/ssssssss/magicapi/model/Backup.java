package org.ssssssss.magicapi.model;

/**
 * 备份记录
 */
public class Backup {

	/**
	 * 记录ID
	 */
	private String id;
	/**
	 * 备份时间
	 */
	private long createDate;

	/**
	 * 标签，只允许有一个
	 */
	private String tag;

	/**
	 * 备份类型，api function datasource
	 */
	private String type;

	/**
	 * 原名称
	 */
	private String name;

	/**
	 * 备份内容
	 */
	private String content;

	/**
	 * 操作人，取用户名，空为系统记录
	 */
	private String createBy;


	public Backup() {
	}

	public Backup(String id, String type, String name, String content) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Backup small(){
		setContent(null);
		return this;
	}
}
