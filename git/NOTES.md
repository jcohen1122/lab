# Git Notes

### Stage all modified files
```bash
git add -A
```

### Create & push new branch
```bash
git checkout -b [branch]
git push -u origin [branch]
```

### Create new local branch from remote branch
```bash
git checkout -b [feature-branch] origin/[remote-branch]
```

### Force delete branch
```bash
git branch -D [branch]
```

### Merge branches
```bash
git checkout [base-branch]
git merge [feature-branch]
git push
```
**Always keep feature branches up to date with their respective base branch**

### Get rid of corrupted branches
```bash
find .git/refs -type f
find .git/refs -type f -name "*name*" -delete
# original branch name without spaces
```

### Create repo from local project
```bash
git init
git remote add origin [repo_url]
git branch -M main
git push -u origin main
```