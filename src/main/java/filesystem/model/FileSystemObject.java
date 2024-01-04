package filesystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "filesystemobject")
public abstract class FileSystemObject {

    @Id
    Integer id;

    String name;

    String author;

    String content;

    String comment;

    String link;

    Integer parent;

    public FileSystemObject() {
    }

    public FileSystemObject(Integer id, String name, String author, Integer parent) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileSystemObject that = (FileSystemObject) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(author, that.author) && Objects.equals(content, that.content) && Objects.equals(comment, that.comment) && Objects.equals(link, that.link) && Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, content, comment, link, parent);
    }
}
