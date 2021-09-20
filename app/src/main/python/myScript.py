import sys
from os.path import dirname,join
from com.chaquo.python import Python

def main(codeData,inputData):

    file_dir=str(Python.getPlatform().getApplication().getFilesDir())

    fileName=join(dirname(file_dir),'file.txt')

    fileNameInput=join(dirname(file_dir),'file1.txt')

    with open(fileNameInput,'w',encoding='utf8',errors='ignore') as f:
        f.write(inputData)



    try:
        original_stdout = sys.stdout

        sys.stdin=open(fileNameInput)

        sys.stdout=open(fileName,'w',encoding='utf8',errors='ignore')

        exec(codeData)

        sys.stdout.close()

        sys.stdout = original_stdout

        output=open(fileName).read()



    except Exception as e:

        sys.stdout = original_stdout

        output = e
        pass

    return str(output)

