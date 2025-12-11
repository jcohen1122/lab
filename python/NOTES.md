# Python Notes

**__init__.py**
- Empty -> All methods are public
- Methods listed -> only those methods are accessible
- Similar to public and private in Java

## Package Manager
```bash
python3.xx -m pip install [package]
# or
pip install [package]
# install specific version
pip install 'package == 1.0.0'
# recursively install
pip install -r requirements.txt
```

## Virtual Environments
```bash
python3.xx -m venv [venv-name]
source [venv-name]/bin/activate
# Then switch interpreter in VS Code using Command + Shift + P
```

## WHL Files
whl files are packages that you can import in Python code

How to build a new whl version
1. run ```pip install wheel``` and ```pip install setuptools```
2. delete egg-info
3. update setup.py version
4. run ```python setup.py bdist_wheel --universal```

If a WHL file you imported into your project cannot be stepped into while debugging, here is the solution:
```bash
pip uninstall [package-name] -y
pip install -e [path-to-repo]
```
Example
```bash
pip uninstall jadnutils -y
pip install -e /Users/jryan/Desktop/JADN_Repos/jadn-utils
```
Then very that it is editable with ```pip show jadnutils```