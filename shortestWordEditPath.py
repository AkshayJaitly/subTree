def shortestWordEditPath(source, target, words):
    res = []

    def helper(current, seen, count):  
        if current == target:
          res.append(count)
          return
        
        for word in words:
          if word not in seen:
            diff_char = 0
            for i in range(len(word)):
              if word[i] != current[i]:
                diff_char += 1
            if diff_char == 1: 
              helper(word, seen + [current], count + 1)

    helper(source, [source], 0)
    return min(res) if res else -1

    
print (shortestWordEditPath("bit", "dog", ["but","put","big","pot","pog","dog","lot"]))
print (shortestWordEditPath("no", "go", ["to"]))
print (shortestWordEditPath("bit", "pog", ["but","put","big","pot","pog","pig","dog","lot"]))
print (shortestWordEditPath("aa", "bb", ["ab","bb"]))
print (shortestWordEditPath("abc", "ab", ["abc","ab"]))
print (shortestWordEditPath("aa", "bbb", ["ab","bb"]))