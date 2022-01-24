package ru.stqa.pft.github;

import com.jcabi.github.*;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

public class GithubTests {
    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("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");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("CasterBanana", "Java_Code")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
