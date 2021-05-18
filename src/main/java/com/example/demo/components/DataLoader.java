package com.example.demo.components;

import com.example.demo.models.File;
import com.example.demo.models.Folder;
import com.example.demo.models.User;
import com.example.demo.repositories.FileRepository;
import com.example.demo.repositories.FolderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        User user1 = new User("Michael");
        userRepository.save(user1);
        User user2 = new User("Pete");
        userRepository.save(user2);
        User user3= new User("Stu");
        userRepository.save(user3);

        Folder folder1 = new Folder("Michael Folder",user1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Pete Folder",user2);
        folderRepository.save(folder2);
        Folder folder3 = new Folder("Stu folder",user3);
        folderRepository.save(folder3);

        File file1 = new File("Week 1","TXT",10,folder1);
        fileRepository.save(file1);
        File file2 = new File("Week 2","TXT",20,folder2);
        fileRepository.save(file2);
        File file3 = new File("Week 3","TXT",30,folder3);
        fileRepository.save(file3);

        folder1.addFiles(file1);
        folderRepository.save(folder1);
        folder2.addFiles(file2);
        folderRepository.save(folder2);
        folder3.addFiles(file3);
        folderRepository.save(folder3);

        file1.addFolder(folder1);
        fileRepository.save(file1);
        file2.addFolder(folder2);
        fileRepository.save(file2);
        file3.addFolder(folder3);
        fileRepository.save(file3);

        user1.addFolders(folder1);
        userRepository.save(user1);
        user2.addFolders(folder2);
        userRepository.save(user2);
        user3.addFolders(folder3);
        userRepository.save(user3);

    }

}
