package fr.insa.model;

import java.util.List;

public class Transform {
    public static Users transformUser(Users users){
        if(users!=null){
            users.setPosts(null);
            users.setComments(null);
            users.setRoutes(null);
        }

        return users;
    }
    public static Posts transformPost(Posts post){
        if(post!=null){
            post.setUser(null);
            post.setComment(null);
        }

        return post;
    }
    public static List<Users> transformUsers(List<Users> users){
        if(users!=null){
            for(int i=0;i<users.size();i++){
                users.get(i).setPosts(null);
                users.get(i).setComments(null);
                users.get(i).setRoutes(null);
            }
        }

        return users;
    }
    public static List<Posts> transformPosts(List<Posts> posts){
        if(posts!=null){
            for(int i=0;i<posts.size();i++){
                posts.get(i).setUser(null);
                posts.get(i).setComment(null);
            }
        }
        return posts;
    }
    public static List<Comments> transformComments(List<Comments> comments){
        if(comments!=null){
            for(int i=0;i<comments.size();i++){
                comments.get(i).setUser(null);
                comments.get(i).setPost(null);
            }
        }
        return comments;
    }
    public static List<Routes> transformRoutes(List<Routes> routes){
        if(routes!=null){
            for(int i=0;i<routes.size();i++){
                routes.get(i).setUsers(null);
            }
        }
        return routes;
    }

}
